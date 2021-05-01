package BooksSorter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Books> books = new ArrayList<>();

		boolean FormAdd=true;
		boolean WrongPrice=false;
		String name="";
		String authorName="";
		double price=0;
		while(FormAdd) {
			Scanner scan=new Scanner(System.in);
			Scanner scan1=new Scanner(System.in);
			
			if(!WrongPrice) {
System.out.println("Name of book :");
name=scan.nextLine();

			}
			System.out.println("Price of the book");

try {
price=scan.nextDouble();
WrongPrice=false;
}
catch(Exception e) 
{
	WrongPrice=true;
}
if(!WrongPrice) {
System.out.println("Name of the author");
authorName=scan1.nextLine();
books.add(new Books(name,price,authorName));
System.out.println("Do you want to exit");
String exit=scan1.nextLine();
if(exit.equals("yes")) 
{
	FormAdd=false;
}
}

		}
		System.out.println("Sorted Names :");
		for(int i=0;i<books.size()-1;i++) 
		{
			System.out.print(SortNames(books).get(i)+" ,");
			
		}
		System.out.print(SortNames(books).get(books.size()-1));
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Sorted Prices :");
		for(int i=0;i<books.size()-1;i++) 
		{
			if(SortPrices(books).get(i)%1==0) {
			System.out.print(SortPrices(books).get(i).intValue()+" ,");
			}else 
			{
				System.out.print(SortPrices(books).get(i)+" ,");
				
			}
			
		}
		if(SortPrices(books).get(books.size()-1)%1==0) {
		System.out.print(SortPrices(books).get(books.size()-1).intValue());
		}
		else 
		{
			System.out.print(SortPrices(books).get(books.size()-1));
			
		}
		System.out.println();
		System.out.println("--------------------------------");
		System.out.println("Sorted Authors :");
		for(int i=0;i<books.size()-1;i++) 
		{
		
			System.out.print(SortAuthors(books).get(i)+" ,");
			
		}
		System.out.print(SortAuthors(books).get(books.size()-1));
	

	}
	public static List<String> SortNames(List<Books> list) {
		String buffer = null;
	
		List<String> Names = new ArrayList<>();
		for (Books book : list) {
			Names.add(book.getName());

		}
		
		for(int i=0;i<Names.size()-1;i++) 
		{
			
			for(int j=0;j<Names.size()-1;j++) 
			{
			
				String T1="";
				String T2="";
				for(int y=0;y<Names.get(j).length();y++) 
				{
					if(Names.get(j).charAt(y)!=' ') 
					{
						T1+=Names.get(j).charAt(y);
						
					}
					
				}
				
				for(int y=0;y<Names.get(j+1).length();y++) 
				{
					if(Names.get(j+1).charAt(y)!=' ') 
					{
						T2+=Names.get(j+1).charAt(y);
						
					}
					
				}
		
				int z=0;
				String name1=Names.get(j);
				String name2=Names.get(j+1);	
				try {
						T1=T1.toLowerCase();
						T2=T2.toLowerCase();
	                    while(T1.charAt(z)==T2.charAt(z)) 
	                    {
	                    
	                    	z++;
	                    	
	                    }
	     
						if(T1.charAt(z)>T2.charAt(z)) 
						{
						buffer=name1;
						Names.set(j, name2);
						Names.set(j+1, buffer);		
						
						
	                    }
			
				}
				catch(Exception e) 
				{
					if(T1.length()>T2.length()) 
					{
						buffer=name1;
						Names.set(j, name2);
						Names.set(j+1, buffer);		
						
						
						
					}
					
				}
				
				
				
			}
			
		}
			

	

	
		return Names;

	}
    public static List<Double> SortPrices(List<Books> list)
    {
    	double buffer=0;
    	List<Double> prices=new ArrayList<>();
    	for(Books book:list) 
    	{
    		prices.add(book.getPrice());
    		
    	}
    	for(int i=0;i<prices.size()-1;i++) 
    	{
    		for(int j=0;j<prices.size()-1;j++) 
    		{
    			double price1=prices.get(j);
    			double price2=prices.get(j+1);
    			if(price1>price2) 
    			{
    				buffer=price1;
    				prices.set(j, price2);
    				prices.set(j+1, buffer);
    			}
    		}
    		
    	}
    	return prices;
    	
    }
    public static List<String> SortAuthors(List<Books> list) {
    	String buffer = null;
    	int x=0;
		List<String> Names = new ArrayList<>();
		for (Books book : list) {
			Names.add(book.getAuthor());

		}
		
		for(int i=0;i<Names.size()-1;i++) 
		{
			
			for(int j=0;j<Names.size()-1;j++) 
			{
			
				String T1="";
				String T2="";
				for(int y=0;y<Names.get(j).length();y++) 
				{
					if(Names.get(j).charAt(y)!=' ') 
					{
						T1+=Names.get(j).charAt(y);
						
					}
					
				}
				
				for(int y=0;y<Names.get(j+1).length();y++) 
				{
					if(Names.get(j+1).charAt(y)!=' ') 
					{
						T2+=Names.get(j+1).charAt(y);
						
					}
					
				}
		
				int z=0;
				String name1=Names.get(j);
				String name2=Names.get(j+1);	
				try {
						T1=T1.toLowerCase();
						T2=T2.toLowerCase();
	                    while(T1.charAt(z)==T2.charAt(z)) 
	                    {
	                    
	                    	z++;
	                    	
	                    }
	     
						if(T1.charAt(z)>T2.charAt(z)&&!T1.equals(T2)) 
						{
						buffer=name1;
						Names.set(j, name2);
						Names.set(j+1, buffer);		
						
						
	                    }
						
				}
				catch(Exception e) 
				{
					if(T1.length()>T2.length()) 
					{
						buffer=name1;
						Names.set(j, name2);
						Names.set(j+1, buffer);		
						
					
						
					}
					
				}
				
				
				
			}
			
		}
	
			
		
		
	
		

	

	
		return Names;

	}
  
}
