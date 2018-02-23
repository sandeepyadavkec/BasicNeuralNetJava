package neural;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class Neuron {
	
	List<Double> m_outputWeights = new ArrayList<Double>();
	List<Double> m_deltaWeights = new ArrayList<Double>();
	double m_outputVal;
	Random rand = new Random();
	int m_myIndex;
	double m_gradient;
	static double eta = 0.15;
	static double alpha = 0.5;
	
	public Neuron(int numOutputs, int myIndex){
				
		for(int c=0; c < numOutputs; c++) {
			m_outputWeights.add(c, rand.nextDouble());
			m_deltaWeights.add(0.0);
			//System.out.println("Weight, index: "+m_outputWeights.get(c)+", "+c);
		}
		m_myIndex = myIndex;		
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
			sum += prevLayer.get(n).getOutputVal() * 
			prevLayer.get(n).m_outputWeights.get(m_myIndex);
		}
		m_outputVal=transferFunction(sum);
		
	}

	private double transferFunction(double x) {
		//return 1.0 - x * x;
		return Math.tanh(x);
	}
	
	private double transferFunctionDerivative(double x) {
		// tanh derivative
		return 1.0 - x * x;		
	}

	public void calcOutputGradients(Double targetVal) {
		// TODO Auto-generated method stub
		double delta = targetVal - m_outputVal;
		m_gradient = delta * transferFunctionDerivative(m_outputVal);
	}

	public void calcHiddenGradients(List<Neuron> nextLayer) {
		// TODO Auto-generated method stub
		double dow = sumDOW(nextLayer);
		m_gradient = dow * transferFunctionDerivative(m_outputVal);		
	}

	private double sumDOW(List<Neuron> nextLayer) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		
		for(int n=0; n < nextLayer.size()-1; n++) {
			sum += m_outputWeights.get(n).doubleValue() * nextLayer.get(n).m_gradient;
		}
		return 0;
	}

	public void updateInputWeights(List<Neuron> prevLayer) {
		// TODO Auto-generated method stub
		
		for(int n=0; n < prevLayer.size(); n++) {
			Neuron neuron = prevLayer.get(n);
			double oldDeltaWeight = neuron.m_deltaWeights.get(m_myIndex).doubleValue();
			
			//Individual input, magnified by the gradient and the training rate
			double newDeltaWeight = eta * neuron.getOutputVal() * m_gradient + alpha * oldDeltaWeight;
			
			neuron.m_deltaWeights.add(m_myIndex, newDeltaWeight);
			neuron.m_outputWeights.add(m_myIndex, neuron.m_outputWeights.get(m_myIndex)+newDeltaWeight);
		}
		
	}

}
