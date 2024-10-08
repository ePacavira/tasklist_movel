package ao.co.isptec.aplm.tasklist;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa o EditText, Button e ListView
        EditText editTextTask = findViewById(R.id.editTextTask);
        Button buttonAddTask = findViewById(R.id.buttonAddTask);
        ListView listViewTasks = findViewById(R.id.listViewTasks);

        // Inicializa o ArrayList e o ArrayAdapter
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(adapter);

        // Ação ao clicar no botão "Adicionar Tarefa"
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Captura a tarefa digitada
                String task = editTextTask.getText().toString().trim();
                if (!task.isEmpty()) {
                    // Adiciona a tarefa no topo da lista
                    taskList.add(0, task);
                    // Notifica o adaptador para atualizar o ListView
                    adapter.notifyDataSetChanged();
                    // Limpa o campo de texto
                    editTextTask.setText("");
                }
            }
        });
    }
}

