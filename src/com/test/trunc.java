package com.test;

import java.lang.Math;
public class trunc {

	
	public  String truncate( String orderDetails, int number){
		String orderdetails="";
		if (orderDetails!=null && orderDetails.length()>number && number >=21){
			
			String subOrderDetails=orderDetails.substring(0,number);
			double pos = number-21;
			int posValue=(int)(Math.round(pos/2));
			double valueDiff=((Math.round(pos/2))-pos/2);
			if(valueDiff==0){
				
				String frontChar=subOrderDetails.substring(0,posValue);
				String endChar=subOrderDetails.substring(Math.max(0, subOrderDetails.length() - posValue));
				StringBuffer str = new StringBuffer(frontChar);
				str.append(" ...(truncated) ... ");
				str.append(endChar);
				orderdetails=str.toString();
				
			}
			else{
				
				String frontChar=subOrderDetails.substring(0,posValue);
				String endChar=subOrderDetails.substring(Math.max(0, subOrderDetails.length() - (posValue-1)));
				StringBuffer str = new StringBuffer(frontChar);
				str.append("...(truncated) ... ");
				str.append(endChar);
				orderdetails=str.toString();
				
			}
		}
		else{
			orderdetails="Will not Change the Input";
			
		}
		System.out.println("result is "+orderdetails);
		return orderdetails ;
		
		} 
		
	public static void main(String args[]){
		trunc tr= new trunc();
		tr.truncate( "123456789012345678901234567890" , 25);
		
		
	}
	}

