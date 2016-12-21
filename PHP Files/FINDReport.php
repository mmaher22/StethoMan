<?php
require "CONN.php";
$myid = urldecode($_POST['myid']);

$out = "REPORT:";
$mysql_qry = "select * FROM report WHERE PatientID = '".$myid."' ";
$result = mysql_query($mysql_qry);

while($row_data = mysql_fetch_array($result))
{
  $spec = $row_data['Specialization'];
  $desc = $row_data['Description'];
  $tit = $row_data['Title'];
  $time = $row_data['Time'];
  
  $out = $out."$".$tit." at ".$time." - ".$spec."^".$desc;
}
echo $out."$";
?>