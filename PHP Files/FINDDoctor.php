<?php
require "CONN.php";

$out = "DOC";
$mysql_qry = "select * from doctor ";
$result = mysql_query($mysql_qry) ;

while($row_data = mysql_fetch_array($result))
{
  $name = $row_data['Name'];
  $id = $row_data['DoctorID'];
  $out = $out."-".$name." ID: ".$id;
}

$out = $out."-";
echo $out;
?>	