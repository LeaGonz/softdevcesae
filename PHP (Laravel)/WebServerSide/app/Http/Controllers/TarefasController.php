<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class TarefasController extends Controller
{
    public function showTarefas()
    {

        $tarefas = $this -> getTarefas();
        $availableTasks = $this -> availableTasks();

        return view("tarefas.allTarefas", compact('tarefas', 'availableTasks'));
    }

    private function getTarefas()
    {
        $tasks = [
            ['name' => 'Rita', 'task' => 'Estudar laravel'],
            ['name' => 'Luis', 'task' => 'Estudar PHP'],
            ['name' => 'Licinio', 'task' => 'Estudar Vue.js'],
            ['name' => 'Shiago', 'task' => 'Estudar React.js'],
            ['name' => 'Sara', 'task' => 'Ensinar laravel'],
        ];

        return $tasks;
    }

    private function availableTasks()
    {
        $availableTasks=['sql', 'js', 'Java', 'POO'];

        return $availableTasks;
    }
}
