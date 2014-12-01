package com.example.reidaesfiha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	// Array de String
    String[] sabores = new String[] {
            "Carne",
            "Queijo",
            "Frango",
            "Espinafre",
            "Cheddar",
            "Calabresa",
            
    };
    
    // Array de imagens na pasta /res/drawable-mdpi/
    int[] esfihasimg = new int[]{
    		R.drawable.carne,
    		R.drawable.queijo,
    		R.drawable.frango,
    		R.drawable.espinafre,
    		R.drawable.cheddar,
    		R.drawable.calabresa,
    		
    };
	
    // Array of strings 
    String[] precos = new String[]{
    	"R$3,00",
    	"R$3,00",
    	"R$3,00",
    	"R$4,00",
    	"R$4,00",
    	"R$4,00",
    	
    };
    
    
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
      
        // Mapeia com hash as linhas do array
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();        
        
        for(int i=0;i<6;i++){
        	HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("sabor", sabores[i]);
            hm.put("preco", precos[i]);
            hm.put("imgagem", Integer.toString(esfihasimg[i]) );            
            aList.add(hm);        
        }
        
        // Chaves usadas no Hashmap
        String[] from = { "imgagem","sabor","preco" };
        
        // Ids no listview_layout
        int[] to = {R.id.imgagem, R.id.sabor,R.id.preco};        
        
        // Instancia um adapter p/cada linha
        // R.layout.listview_layout define layout p/cada linha
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout,from, to);
        
        // Pega referencia do listview no main_activity.xml 
        ListView listView = ( ListView ) findViewById(R.id.listView1);
        
        // Setting the adapter to the listView
        listView.setAdapter(adapter);                                
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
