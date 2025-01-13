<?php
$txt = "json.txt";
$json = file_get_contents($txt);
$arraydados = json_decode($json);
if (isset($arraydados)){
    // print_r($json);
        echo "<table>";
        echo "<tr>";
        echo "<th>Nome</th>";
        echo "<th>Apelido</th>";
        echo "<th>Email</th>";
        echo "<th>Password</th>";
        echo "<th>Data Nascemento</th>";
        echo "<th>Telemovel</th>";
        echo "<th>Foto Perfil</th>";
        echo "</tr>";
        
    foreach($arraydados as $dados => $dado) {
        echo "<tr>";
        echo "<td>". $dado->firstname ."</td>";
        echo "<td>". $dado->lastname ."</td>";
        echo "<td>". $dado->email ."</td>";
        echo "<td>". $dado->password ."</td>";
        echo "<td>". $dado->birthdate ."</td>";
        echo "<td>". $dado->telemovel ."</td>";
        echo "<td>". $dado->image ."</td>";
        echo "</tr>";
    }
    echo "</table>";
} else {
    echo "<h1>Não há data para mostrar</h1>";
}
?>
<style>
        table {
            border-collapse: collapse; 
            width: 100%; 
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 15px;
            text-align: center; 
        }
    </style>