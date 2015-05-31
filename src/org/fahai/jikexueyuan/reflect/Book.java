package org.fahai.jikexueyuan.reflect;

public class Book {

	private Integer id;
	private String name;
	private String type;
//	public String forFieldTest;
	
	public Book(){
		
	}
	
	public Book(Integer id, String name, String type){
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
//		System.out.println("getName is called~~~~~~~");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
//	public void setIdAndName(Integer id, String name){
//		this.id = id;
//		this.name = name;
//	}
	
	public String toString(){
		return "id: " + id + "\t name: " + name + "\t type: " + type;
	}

}
