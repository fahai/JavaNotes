/* 
 * Copyright (c) 2015, S.F. Express Inc. All rights reserved.
 */
package org.fahai.app.lunch.bean;

import java.util.ArrayList;

/**
 * 描述：
 * 
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    2015年6月1日      449631         Create
 * ****************************************************************************
 * </pre>
 * 
 * @author 449631
 * @since 1.0
 */
public class Shop {

	private String name;
	private ArrayList<Meal> meals;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}

}
