<?php
   include_once("config.inc.php");

    if(isset($_POST['name']) &&isset($_POST['pwd']) &&isset($_POST['admno']) &&
    	 isset($_POST['centr']) &&isset($_POST['year']) &&isset($_POST['wrkun'])  &&
      isset($_POST['team']) &&isset($_POST['phnno']) &&isset($_POST['email'])  &&
       isset($_POST['brnch']))
	   { 
  
	 
	 $name = $_POST['name'];
	 $pwd = $_POST['pwd'];
	 $admno = $_POST['admno'];
	 $centr = $_POST['centr'];
	 $year = $_POST['year'];
	 $wrkun = $_POST['wrkun'];
	 $brnch =$_POST['brnch'];
	 $team = $_POST['team'];
	 $phnno = $_POST['phnno'];
	 $email =$_POST['email'];
	 
	 $query = "UPDATE `reg_student` SET `year`='$year',`name`='$name',`admno`='$admno',`pass`='$pwd',`branch`='$brnch',
	           `centr`='$centr',`wrkun`='$wrkun',`team`='$team',`phnno`='$phnno',`email`='$email' WHERE `admno`='$admno'" ;
	 
	// $query = "INSERT INTO `reg_student`(`year`, `name`, `admno`, `pass`, `branch`, `centr`, `wrkun`, `team`, `phnno`, `email`) 
	  //         VALUES ('$year','$name','$admno','$pwd','$brnch','$centr','$wrkun','$team','$phnno','$email') WHERE `admno`='$admno'";
	
      $entruser = "UPDATE `users` SET `index`='',`username`='$admno',`password`='$pwd' WHERE `admno`='$admno'";	
	 //$entruser = "INSERT INTO `users`(`index`, `username`, `password`) VALUES ( '','$admno','$pwd') WHERE `admno`='$admno'";

     $user =  $conn->query($entruser);	 
			   
	 $result = $conn->query($query);

    if($result)
    {
	 
	    echo "success";
		exit;
	   
    }else{
	       
            echo "failed";
       
	      }
     	
 }
?>