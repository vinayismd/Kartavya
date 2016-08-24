<?php
    //session_start();
   include_once("config.inc.php"); 
	
 if(isset($_POST['centre']) && isset($_POST['team'])){
    
    $centre = $_POST['centre'];
    $team = $_POST['team'];
	
	// $centre="Centre3";
	 //$team="School";
	 
	
	////$_SESSION["centre"] = $centre;
	//$_SESSION["team"]= $team;
	
	//echo '<a href="memberlist.php?c=$centre"></a>';
	//echo '<a href="memberlist.php?t=$team"></a>';
	
	//$str="http://localhost/kartavya/memberlist.php?centre=".$centre."&team=".$team;
	
    $query = "SELECT * FROM reg_student WHERE `centr` = '$centre' 
        AND `team` = '$team'";

    $result = mysqli_query($conn, $query);
    if($result->num_rows > 0){ //has record. correct username and password
                 
	    echo "success";
		
		//header("Location: memberlist.php");
        exit;
    }
    else{
        echo "No Members In List"; 
        exit;
    }
	
	 
	}
?>