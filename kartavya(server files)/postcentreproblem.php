<?php
     include_once("config.inc.php");
	 
	 if(isset($_POST['centre']) &&isset($_POST['title']) &&isset($_POST['desc']) ){
	    
		$admno = $_POST['admno'];
		$centre = $_POST['centre'];
	    $title = $_POST['title'];
	    $desc = $_POST['desc'];
		//$qname = "SELECT name from reg_student where admno='$admno' ";
		//$name = mysqli_query($conn,"SELECT `name` from `reg_student` where admno='$admno'; ");
		$res=mysqli_query($conn,"SELECT * from `reg_student` where admno='$admno'; ");
		//$qphnno = "SELECT phnno from reg_student where admno='$admno' ";
		//$phnno =  mysqli_query($conn,"SELECT `phnno` from `reg_student` where `admno`='$admno'; ");
		$arr=$res->fetch_array();
		$name=$arr['name'];
		$phnno=$arr['phnno'];
		
		$postprob = "INSERT INTO `centreproblems`(`name`, `admno`, `centre`, `phnno`, `title`, `desc`)
             		VALUES ('$name','$admno','$centre','$phnno','$title','$desc')";
					
		$result = mysqli_query($conn, $postprob);
        if($result)
         { 
	        echo "success";
		    exit;
       }else{
            echo "failed";
            exit;
        
		}
	}	

?>