<?php
   include_once("config.inc.php");
   
     $c1 =$_POST['centre'];  $t1= $_POST['team']// $c2 = $_POST['sc2']; $c3 = $_POST['sc3'];$c4 = $_POST['sc4'];
	 //$cn = $_POST['scn']; $t1 = $_POST['st1'];$t2 =$_POST['st2'];$t3 = $_POST['st3'];
	// $t4 = $_POST['st4'];$t5 = $_POST['st5'];$t5 = $_POST['st6'];$tn =$_POST['stn'];

    $query = "SELECT * FROM `reg_student` where `centr` = '$c1' "  or `team` = '$t1'; // ('$c1','$c2','$c3','$c4','$cn' ) or
	         // `team` in ('$t1','$t2','$t3','$t4','$t5','$t6','$tn');"; 
    
    $result = mysqli_query($conn, $query);
   
    while($row = mysqli_fetch_assoc($result)){
            $data[] = $row;
    }
    echo json_encode($data);
     
	 
?>