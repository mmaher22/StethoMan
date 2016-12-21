<?php
require "CONN.php";
//echo "Error:"
$myid = urldecode($_POST['myid']);
$docid = urldecode($_POST['docid']);
$review = urldecode($_POST['review']);

$mysql_qry = "SELECT * FROM review WHERE DoctorID = '".$docid."' AND PatientID = '".$myid."' ";
$result = mysql_query($mysql_qry) ;

$mysql_qry = "SELECT Review FROM doctor WHERE DoctorID = '".$docid."' ";
$result2 = mysql_query($mysql_qry);
$row = mysql_fetch_row($result2);
$review = ($review + $row[0])/2;

if(mysql_num_rows($result) > 0)
{
  $sql = "UPDATE review SET Review = '".$review."' WHERE DoctorID = '".$docid."' AND PatientID = '".$myid."' ";
  $result = mysql_query($sql);

  $sql = "UPDATE doctor SET Review = '".$review."' WHERE DoctorID = '".$docid."' ";
  $result = mysql_query($sql);
  echo "Review is Updated";
}
else
{
  $sql = "INSERT INTO review (PatientID, DoctorID, Review) VALUES ('".$myid."', '".$docid."', '".$review."') ";
  $result = mysql_query($sql);
if(!$result) echo "Error: ".mysql_error();
  $sql = "UPDATE doctor SET Review = '".$review."' WHERE DoctorID = '".$docid."' ";
  $result = mysql_query($sql);
  echo "Review is Added";
}

?>		