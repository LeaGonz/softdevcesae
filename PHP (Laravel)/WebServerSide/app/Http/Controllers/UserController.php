<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function userAll()
    {
        $cesaeInfo = $this->getCesaeInfo();
        $contacts = $this->getContacts();
        return view('users.all_users', compact('cesaeInfo','contacts'));
    }

    public function userAdd()
    {
        return view('users.add_user');
    }

    private function getCesaeInfo()
    {
        $cesaeInfo = [
            'name' => 'Cesae',
            'address' => 'Rua Ciríaco Cardoso 186, 4150-212 Porto',
            'email' => 'cesae@cesae.pt'
        ];
        return $cesaeInfo;
    }

    private function getContacts()
    {
        $contacts = [
            ['id' => 1, 'name' => 'Luis', 'phone' => '900901901'],
            ['id' => 2, 'name' => 'Licinio', 'phone' => '900901902'],
            ['id' => 3, 'name' => 'Shiago', 'phone' => '900901903'],
        ];
        return $contacts;
    }
}
