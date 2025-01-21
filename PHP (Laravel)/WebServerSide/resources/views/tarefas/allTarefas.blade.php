@extends('layouts.fo_layout')
@section('content')
    <h1>TAREFAS</h1>
    <ul>
        @foreach ($tarefas as $tarefa)
        <li>{{$tarefa['name']}} | {{$tarefa['task']}}</li>
        @endforeach
    </ul>
    <h1>AVAILABLE TASKS</h1>
    <ul>
        @foreach ($availableTasks as $availableTask)
        <li>{{$availableTask}}</li>
        @endforeach
    </ul>
@endsection
