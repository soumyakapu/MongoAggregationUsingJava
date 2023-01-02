package com.query.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.query.bean.Dummy;

@Component
public class DummyRepoImp implements DummyRepo {

	
	@Autowired
	MongoClient mongoClient;
	
	@Autowired
	MongoConverter mongoConverter;
	
	@Override
	public List<Dummy> findAggregateByUser(String user) {
		List<Dummy> dummys = new ArrayList<>();
		
		MongoDatabase database = mongoClient.getDatabase("Oneable");
		MongoCollection<Document> collection = database.getCollection("Dummy");
		
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match", 
			    new Document("user", user)), 
			    new Document("$group", 
			    new Document("_id", 
			    new Document("user", "$user")
			                .append("day", 
			    new Document("$dateToString", 
			    new Document("format", "%Y-%m-%d")
			                        .append("date", "$Date")))
			                .append("totalDaysWorkedHours", 
			    new Document("$sum", 
			    new Document("$subtract", Arrays.asList("$endTime", "$startTime"))))
			                .append("month", 
			    new Document("$dateToString", 
			    new Document("format", "%Y-%m")
			                        .append("date", "$Date")))
			                .append("totalMonthsWorkedHours", 
			    new Document("$sum", 
			    new Document("$subtract", Arrays.asList("$endTime", "$startTime"))))
			                .append("year", 
			    new Document("$dateToString", 
			    new Document("format", "%Y")
			                        .append("date", "$Date"))))), 
			    new Document("$group", 
			    new Document("_id", 
			    new Document("user", "$_id.user")
			                .append("month", "$_id.month")
			                .append("year", "$_id.year"))
			            .append("month", 
			    new Document("$push", 
			    new Document("day", "$_id.day")
			                    .append("totalDaysWorkedHours", "$_id.totalDaysWorkedHours")))
			            .append("totalMonthsWorkedHours", 
			    new Document("$sum", "$_id.totalDaysWorkedHours"))), 
			    new Document("$group", 
			    new Document("_id", 
			    new Document("user", "$_id.user")
			                .append("year", "$_id.year"))
			            .append("year", 
			    new Document("$push", 
			    new Document("month", "$_id.month")
			                    .append("days", "$month")
			                    .append("totalMonthsWorkedHours", "$totalMonthsWorkedHours")))
			            .append("totalYearWorkedHours", 
			    new Document("$sum", "$totalMonthsWorkedHours"))), 
			    new Document("$group", 
			    new Document("_id", "$_id.user")
			            .append("user", 
			    new Document("$push", 
			    new Document("year", "$_id.year")
			                    .append("months", "$year")
			                    .append("totalYearWorkedHours", "$totalYearWorkedHours")))
			            .append("totalUserDuration", 
			    new Document("$sum", "$totalYearWorkedHours")))));
		
		for(Document document: result) {
			System.out.println(document);
			dummys.add(mongoConverter.read(Dummy.class, document));
		}
	
		return dummys;
	}

}
