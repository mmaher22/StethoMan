<?php
require "CONN.php";
//$user_ID=urldecode($_POST['doctorid']);;
//$user_ID="201301111";
if($_SERVER['REQUEST_METHOD']=='GET'){
		$id = $_GET['id'];


//$image = $_POST['image'];

$mysql_qry = "select Img from doctor  WHERE DoctorID ='".$id."' ";
$retval = mysql_query( $mysql_qry);

$result = mysql_fetch_array($retval);


header('content-type: image/jpeg');
 
echo base64_decode($result['Img']);
 }

?>	

