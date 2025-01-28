<?php

use App\Http\Controllers\HomeController;
use App\Http\Controllers\TarefasController;
use App\Http\Controllers\UserController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/home', [HomeController::class,'index'])->name('home');

Route::get('/users', [UserController::class, 'userAll'])->name('users.show');

Route::get('/add-users', [UserController::class, 'userAdd'])->name('users.add');

Route::get('/tarefas', [TarefasController::class, 'showTarefas'])->name('tarefas.allTarefas');

Route::get('/hello/{name}', function($name){
    return '<h1>Hello</h1>'.$name;
});

Route::fallback(function(){
    return view('fallback');
});
