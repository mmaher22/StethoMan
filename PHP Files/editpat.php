<?php
require "CONN.php";
$user_ID=urldecode($_POST['myid']);
//$user_ID=14

//$doct_ID=urldecode($_POST['docid']);
$doct_ID=201301111;
//$table_name = urldecode($_POST['table']);
$table_name="visit";



$mysql_qry = "select * from ".$table_name. " where PatientID ='".$user_ID."'  ";


$result = mysql_query($mysql_qry) ;

if(mysql_num_rows($result) > 0 && $table_name == "visit" ) {
  $row = mysql_fetch_array($result);  
  if($row['DoctorID'] == $doct_ID) echo "Found  Successfully";
  else echo "Error: 2)PatientID and DoctorID Combination does Not match";
}

else echo "Error: 1)UserID and Password Combination does Not exist";


mysql_close($connect);





?>	




	