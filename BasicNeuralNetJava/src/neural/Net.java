/**
 * 
 */
package neural;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SandeepYadav
 *
 */
public class Net {
	
	List<List<Neuron>> m_layers = new ArrayList<List<Neuron>>();
	
	public Net(List<Integer> topology){
		
		int numLayers = topology.size();
		List<Neuron> Layer = new ArrayList<Neuron>();
				
		for(int layerNum=0; layerNum < numLayers; layerNum++) {
			m_layers.add(Layer);				
			int numOutputs = (layerNum == numLayers-1) ? 0 : topology.get(layerNum+1);
			for(int neuronNum=0; neuronNum <= topology.get(layerNum); neuronNum++) {
				Neuron neuron = new Neuron(numOutputs, neuronNum);
				System.out.println("Made a Neuron: layer, neuron: "+layerNum+ ", "+neuronNum);
				m_layers.get(layerNum).add(neuron);
				
			}
			
			m_layers.get(layerNum).get(topology.get(layerNum)).setOutputVal(1.0);
		}
		
	}
	
	public void feedForward(List<Double> inputVals) {
		// TODO Auto-generated method stub
		assert(inputVals.size()==m_layers.get(0).size()-1);
		
		for(int i = 0; i < inputVals.size(); i++) {
			m_layers.get(0).get(i).setOutputVal(inputVals.get(i));
		}
		
		for(int layerNum=1; layerNum < m_layers.size(); layerNum++) {
			List<Neuron> prevLayer = m_layers.get(layerNum-1);
			for(int n=0; n < m_layers.get(layerNum).size()-1; n++) {
				m_layers.get(layerNum).get(n).feedForward(prevLayer);
			}
		}
		
	}

	public void backProp(List<Double> outputVals) {
		// TODO Auto-generated method stub
		
	}

	public void getResults(List<Double> resultVals) {
		// TODO Auto-generated method stub
		
	}
	

}
