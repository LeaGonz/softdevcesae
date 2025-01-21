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
@endsection
