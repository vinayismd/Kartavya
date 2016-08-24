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
	 
	 $query = "INSERT INTO `reg_student`(`year`, `name`, `admno`, `pass`, `branch`, `centr`, `wrkun`, `team`, `phnno`, `email`) 
	           VALUES ('$year','$name','$admno','$pwd','$brnch','$centr','$wrkun','$team','$phnno','$email')";
			  
	 $entruser = "INSERT INTO `users`(`index`, `username`, `password`) VALUES ( '','$admno','$pwd')";

     $user =  $conn->query($entruser);	 
			   
	$result = $conn->query($query);

    if($result >0 && $user >0)
    {
	  if(isset($_POST['mobile']) && $_POST['mobile'] == "android")
	  {
	    echo "success";
		exit;
	   }
	   echo "Insert successfully";
    }else{
	       if(isset($_POST['mobile']) && $_POST['mobile'] == "android"){
            echo "failed";
            exit;
        }
           echo "Something Error";
	      }
     	
  }
?>
<html>
<head><title>Insert</title></head>
    <body>
        <h1>gchc</h1>
        <form action="<?php $_PHP_SELF ?>" method="post">
            Name <input type="text" name="name" value=""/><br/>
            Qty <input type="text" name="admno" value=""/><br/>
            Price <input type="text" name="centr" value=""/><br/>
            Image URL <input type="text" name="pwd" value=""/><br/>
            <input type="submit" name="btnSubmit" value="Insert"/>
        </form>
    </body>
</html>