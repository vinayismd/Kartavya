<?php

include_once("config.inc.php");

    $query = "SELECT * FROM achievements "; 
    
    $result = mysqli_query($conn, $query);
    
    while($row = mysqli_fetch_assoc($result)){
            $data[] = $row;
    }
    echo json_encode($data);
?>