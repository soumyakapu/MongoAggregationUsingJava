package com.query.repo;

import java.util.List;

import com.query.bean.Dummy;

public interface DummyRepo   {
	List<Dummy> findAggregateByUser(String text);
	
}

