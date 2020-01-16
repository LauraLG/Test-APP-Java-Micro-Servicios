package com.sboot.test.service.ModelService;
import com.sboot.test.service.model.Model;
import com.sboot.test.service.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ModelService {
	@Autowired
	private ModelRepository ModelRepository;
	
	
	private List<Model> models = new ArrayList<>(Arrays.asList(
			new Model ((long) 0, "Java"),
			new Model ((long) 1, "Python"),
			new Model ((long) 2, "JavaScript")		
			));	
    
    public List<Model> getAllModels(){
    	List<Model> models = new ArrayList<>();
    	ModelRepository.findAll().forEach(models::add);
    	return models;
    }
    
    public Model getModel(Long id) {
    	return models.stream().filter(m-> m.getId().equals(id)).findFirst().get();
    }
    
    public void addModels(Model model) {
    	models.add(model); 
    }
    
    public void updateModel(Long id, Model model) {
    	for (int i = 0; i < models.size(); i++) {
    		Model m = models.get(i);
    		if (m.getId().equals(id)) {
    			models.set(i,model);
    			return;
    		}
    	}	
    }
    
    public void deleteModel(Long id) {
    	models.removeIf(m -> m.getId().equals(id));  
    }
    	
    	
    
}