@extends('layouts.fo_layout')
@section('content')
    <h1>Aqui vês todos os users</h1>
    <br>
    <h6>{{$cesaeInfo['name']}}</h6>
    <h6>{{$cesaeInfo['address']}}</h6>
    <h6>{{$cesaeInfo['email']}}</h6>
    <br>
    <tbody>
        @foreach ($contacts as $contact)
        <tr>
            <td>{{$contact['id']}}</td>
            <td> | {{$contact['name']}} | </td>
            <td>{{$contact['phone']}} | </td><br>
        </tr>
        @endforeach
    </tbody>
    <br>
    <table class="table table-success">
        <thead>
          <tr>
            <th scope="col">id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Password</th>
            <th scope="col">Updated at</th>
          </tr>
        </thead>
        <tbody>
        @foreach ($allUsers as $user)
          <tr>
            <th scope="row">{{$user->id}}</th>
            <td>{{$user->name}}</td>
            <td>{{$user->email}}</td>
            <td>{{$user->address}}</td>
            <td>{{$user->password}}</td>
            <td>{{$user->updated_at}}</td>
          </tr>
        @endforeach
        </tbody>
      </table>
@endsection
