<?php
require "CONN.php";

$user_ID=urldecode($_POST['myid']);
$table_name = "report";
$doct_ID=urldecode($_POST['doctid']);
$title=urldecode($_POST['title']);
$specs=urldecode($_POST['specialization']);
$content = ($_POST['content']);
$mysql_qry = "INSERT INTO report (DoctorID,PatientID,Title,Specialization, Description ) VALUES ('".$doct_ID."','".$user_ID."','".$title."','".$specs."','".$content."' )"; 


mysql_select_db('report');
$retval = mysql_query( $mysql_qry, $connect );
if(! $retval )
{
  die('Could not add the medication: ' . mysql_error());
}
echo "report added successfully\n";
mysql_close($connect);

?>	