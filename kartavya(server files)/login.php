<?php
   include_once("config.inc.php");
   
   if(isset($_POST['admno']) && isset($_POST['pwd'])){
    
    $username = $_POST['admno'];
    $password = $_POST['pwd'];
    $query = "SELECT * FROM users WHERE username = '$username' 
        AND password = '$password'";

    $result = mysqli_query($conn, $query);
    if($result->num_rows > 0){ //has record. correct username and password
        echo "success";
        exit;
    }
    else{
        echo "Wrong username and password"; 
        exit;
    }
}
   
?>

<html>
<head><title>Login</title></head>
    <body>
        <h1>Login </h1>
        <form action="<?PHP $_PHP_SELF ?>" method="post">
            Username <input type="text" name="admno" value="" placeholder="Enter Username" /><br/>
            Password <input type="password" name="pwd" value="" placeholder="Enter Password" /><br/>
            <input type="submit" name="btnSubmit" value="Login"/>
        </form>
    </body>
</html>