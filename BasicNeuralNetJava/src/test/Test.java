package test;

import java.util.ArrayList;
import java.util.List;

import neural.Net;

public class Test {

	private static List<Double> inputVals = new ArrayList<Double>();
	private static List<Double> outputVals = new ArrayList<Double>();
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Double> resultVals = null;
		List<Integer> topology = new ArrayList<Integer>();
		topology.add(3);
		topology.add(2);
		topology.add(1);
		Net myNet = new Net(topology);
		
		myNet.feedForward(inputVals);
		myNet.backProp(outputVals);
		myNet.getResults(resultVals);

	}

}
