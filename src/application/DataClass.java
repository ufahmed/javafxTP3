package application;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
	private List<Personne> importList; 
    private List<Personne> exportList;
    public DataClass() {
    	importList =new ArrayList <Personne>();
    	importList.add( new Personne("sami","Ben ali","sami@example.com"));
    	importList.add( new Personne("Alia","Ben salah","alia@example.com"));
    	importList.add( new Personne("Ali","Ben salah","ali@example.com"));
    	exportList=new ArrayList <Personne>();
    }

    public List<Personne> getImportList() {
    	return importList;
    }
    public List<Personne > getExportList() {
    	return exportList;
    }
   
    public void setExportList(List<Personne> exportList) {
    	this.exportList.addAll (exportList);
    	for (Personne p : this.exportList)
    			System.out.println(p);
    }
    
}
