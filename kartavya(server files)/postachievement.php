<?php
    include_once("config.inc.php");
	 
	 //if(isset($_POST['centre']) &&isset($_POST['title']) &&isset($_POST['desc']) ){
	    
		$admno = $_POST['admno'];
	    $title = $_POST['title'];
	    $desc = $_POST['desc'];
		
		$res=mysqli_query($conn,"SELECT * from `reg_student` where admno='$admno'; ");
		
		$arr=$res->fetch_array();
		$name=$arr['name'];
		
		
		$postprob = "INSERT INTO `achievements`(`admno`, `name`, `achievement`, `title`)
                		VALUES ('$admno','$name','$desc','$title')";
					
		$result = mysqli_query($conn, $postprob);
        if($result)
         { 
	        echo "success";
		    exit;
       }else{
            echo "failed";
            exit;
        
		}
	//}
?>