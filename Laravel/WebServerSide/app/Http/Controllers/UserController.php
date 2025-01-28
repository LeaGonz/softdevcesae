<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;


class UserController extends Controller
{
    public function userAll()
    {
        $cesaeInfo = $this->getCesaeInfo();
        $contacts = $this->getContacts();

        // $this->insertUserIntoDB();
        // $this->updateUserIntoDB();
        $allUsers = $this->getAllUsersFromDB();
        // dd($allUsers);

        return view('users.all_users', compact('cesaeInfo', 'contacts','allUsers'));
    }

    public function userAdd()
    {
        return view('users.add_user');
    }

    public function insertUserIntoDB()
    {
        DB::table('users')->insert([
            'name' => 'Shiago',
            'email' => 'shiago@luis.com',
            'password' => '1234luis'
        ]);

        return response()->json('utilizador inserido com sucesso');
    }

    public function updateUserIntoDB()
    {
        DB::table('users')
            ->where('id', 1)
            ->update([
                'updated_at' => now()
            ]);
    }

    protected function getAllUsersFromDB(){
        $users = DB::table('users')
        -> get();
        return $users;
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
