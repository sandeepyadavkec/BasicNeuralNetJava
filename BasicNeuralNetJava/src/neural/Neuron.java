package neural;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Neuron {
	
	List<Double> m_outputWeights = new ArrayList<Double>();
	List<Double> m_deltaWeights = new ArrayList<Double>();
	double m_outputVal;
	Random rand = new Random();
	
	public Neuron(int numOutputs, int neuronNum){
				
		for(int c=0; c < numOutputs; c++) {
			m_outputWeights.add(c, rand.nextDouble());
			System.out.println("Weight, index: "+m_outputWeights.get(c)+", "+c);
		}
	}

	public void setOutputVal(double val) {
		// TODO Auto-generated method stub
		m_outputVal = val;
	}
	
	public double getOutputVal() {
		// TODO Auto-generated method stub
		return m_outputVal;
	}

	public void feedForward(List<Neuron> prevLayer) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		
		for(int n=0; n<prevLayer.size(); n++) {
			
		}
		
		
	}

}
