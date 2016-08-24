<?php
     //session_start();
     include_once("config.inc.php");
	 
	 
	 $c = $_POST['centre'];
	$t = $_POST['team'];
	 
    // $c = "Centre1";
	 //$t = "School";
      //echo $e;
    $query = "SELECT * FROM reg_student where centr ='$c' and team='$t'"; 
    
    $result = mysqli_query($conn, $query);
    
    while($row = mysqli_fetch_assoc($result)){
            $data[] = $row;
    }
    echo json_encode($data);
    
    
?>