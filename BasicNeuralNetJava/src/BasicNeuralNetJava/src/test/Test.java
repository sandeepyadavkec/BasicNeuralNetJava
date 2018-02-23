package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import neural.Net;

public class Test {

	private static List<Double> inputVals = new ArrayList<Double>();
	private static List<Double> targetVals = new ArrayList<Double>();
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Double> resultVals = null;
		List<Integer> topology = new ArrayList<Integer>();
		
		List<List<String>> net = new ArrayList<List<String>>();
		
		topology.add(2);
		topology.add(8);
		topology.add(1);
		Net myNet = new Net(topology);
		Random rand = new Random();
		
		for(int i =0; i<200000; i++) {
			//System.out.println("Pass: "+i);
			inputVals.clear();
			targetVals.clear();
			int a = (int)(2*rand.nextDouble());
			inputVals.add((double)a);
			int b = (int)(2*rand.nextDouble());
			inputVals.add((double)b);
			//System.out.println("in: "+(double)a+"\t"+(double)b);
			myNet.feedForward(inputVals);
			
			resultVals = myNet.getResults();
			//System.out.println("result: "+resultVals.get(0).doubleValue());
			
			
			int c = logicalXOR(a,b);
			targetVals.add((double)c);
			
			//System.out.println("target: "+(double)c);
			
			
			myNet.backProp(targetVals);
		}
		/*
		for(int i=0;i<3;i++) {
			List<String> Layer = new ArrayList<String>();			
			for(int j=0;j<4;j++){
				Layer.add((j), "abc"+i+j);
			}
			net.add(i, Layer);
		}
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++){
				System.out.println(i+j+net.get(i).get(j));
			}
		}*/
		
		
		//
		//
		
		
		
		

	}
	
	private static void feedForward(List<String> layer) {
		// TODO Auto-generated method stub
		
		
	}

	public static int logicalXOR(int a, int b) {
		if((a==0 && b==0) || (a==1 && b==1)) {
			return 0;
		}
		return 1;
			
	}

}
