<?php
require "CONN.php";
$docid = urldecode($_POST['docid']);

$out = "SLOT";
$mysql_qry = "select Time, SlotID from timeslot WHERE DoctorID = '".$docid."' AND Time > NOW()";
$result = mysql_query($mysql_qry) ;

while($row_data = mysql_fetch_array($result))
{
  $time = $row_data['Time'];
  $id = $row_data['SlotID'];
  $out = $out."/".$time." ID* ".$id;
}
$out = $out."/";

echo $out;
?>	