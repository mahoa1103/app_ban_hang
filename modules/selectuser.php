
<?php
	if(isset($_GET['trang'])){
		$trang=$_GET['trang'];
	}else{
		$trang='';
	}
	if($trang =='' || $trang =='1'){
		$trang1=0;
	}else{
		$trang1=($trang*5)-5;
	}
	$sql_lietkesp="select * from nguoidung order by id desc limit $trang1,5 ";
	$row_lietkesp=mysqli_query($conn,$sql_lietkesp);

?>

<table width="100%" border="1">
  <tr>
    <td>STT</td>
    <td>Tên tài khoản</td>
    <td>Quyền</td>
  </tr>
  <?php
  $i=1;
  while($dong=mysqli_fetch_array($row_lietkesp)){

  ?>
  <tr>
  	
    <td><?php  echo $i;?></td>
    <td><?php echo $dong['taikhoan'] ?></td>
    <td><?php echo $dong['quyen'] ?>
    </td>
  </tr>
  <?php
  $i++;
  }
  ?>
</table>
<div class="trang">
	Trang :
    <?php
	$sql_trang=mysqli_query($conn,"select * from nguoidung");
	$count_trang=mysqli_num_rows($sql_trang);
	$a=ceil($count_trang/5);
	for($b=1;$b<=$a;$b++){
		
		if($trang==$b){
		
		echo '<a href="index.php?quanly=nguoidung&ac=lietke&trang='.$b.'" style="text-decoration:underline;color:red;">'.$b.' ' .'</a>';
        
	}else{
		echo '<a href="index.php?quanly=nguoidung&ac=lietke&trang='.$b.'" style="text-decoration:none;color:#000;">'.$b.' ' .'</a>';
	}
	}
	?>
</div>
