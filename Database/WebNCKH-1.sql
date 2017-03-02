drop database DB_WebNCKH
create database DB_WebNCKH

use DB_WebNCKH

create table TaiKhoan(
MaTK varchar(20) primary key,
MatKhau varchar(20),
Quyen nvarchar(50),
HoTen nvarchar(50),
NgaySinh date,
Nganh nvarchar(50),
Email varchar(50),
HinhAnh varchar(100),
MSNH varchar(20),
CNNH nvarchar(50)
);
create table ThongBao(
MaTB varchar(20) primary key,
NguoiGui varchar(20),
NguoiNhan varchar(20),
foreign key (NguoiGui) references TaiKhoan(MaTK),
foreign key (NguoiNhan) references TaiKhoan(MaTK)
);
create table LoaiTB(
MaLTB varchar(20) primary key,
TenLoaiTB nvarchar(50)
);
create table TB_TK(
MaCTTB varchar(20) primary key,
MaTB varchar(20),
MaLTB varchar(20),
TinTB nvarchar(100),
NgayGui Date,
foreign key (MaLTB) references LoaiTB(MaLTB),
foreign key (MaTB) references ThongBao(MaTB)
);

create table TrangThai(
MaTT varchar(20) primary key,
TenTT nvarchar(50)
);

create table DeTai(
MaDT varchar(20) primary key,
MaHienThi varchar(20),
MaTT varchar(20),
MaCN varchar(20),
SinhVien1 varchar(20),
SinhVien2 varchar(20),
GVHD varchar(20),
TenDT nvarchar(200),
MoTa nvarchar(1000),
LinhVuc nvarchar(50),
LoaiHinh nvarchar(50),
NgayThucHien date,
NgayKetThuc date,
CoQuanChuTri nvarchar(50),
TinhHinhTrong nvarchar(200),
TinhHinhNgoai nvarchar(200),
TinhCapThiet nvarchar(200),
MucTieu nvarchar(200),
PPNC nvarchar(200),
NoiDungNC nvarchar(200),
SPDuKien nvarchar(200),
DiaChiUD nvarchar(200),
KinhPhi double,
foreign key(MaCN) references TaiKhoan(MaTK),
foreign key(GVHD) references TaiKhoan(MaTK),
foreign key(SinhVien1) references TaiKhoan(MaTK),
foreign key(SinhVien2) references TaiKhoan(MaTK),
foreign key(MaTT) references TrangThai(MaTT)
);
create table BaoCaoDT(
MaDT varchar(20),
MaBC varchar(20),
TenBC nvarchar(200),
FileBC varchar(500),
NgayBC date,
primary key (MaDT, MaBC),
foreign key(MaDT) references DeTai(MaDT)
);
create table HoiDong(
MaHD varchar(20) primary key,
PhanBien varchar(20),
ChuTich varchar(20),
UyVien varchar(20),
NgayThanhLap date,
foreign key (PhanBien) references TaiKhoan(MaTK),
foreign key (ChuTich) references TaiKhoan(MaTK),
foreign key (UyVien) references TaiKhoan(MaTK)
);
create table CTNghiemThu(
MaDT varchar(20),
MaHD varchar(20),
TongQuan int,
MucTieu int,
PhuongPhap int,
NoiDung int,
DongGop int,
HinhThuc int,
DiemThuong int,
TongDiem int,
YKien nvarchar(1000),
NgayNT date,
MaTK varchar(20), -- tai khoan nghiem thu
primary key (MaDT, MaHD,MaTK),
foreign key (MaHD) references HoiDong(MaHD),
foreign key (MaDT) references DeTai(MaDT),
foreign key (MaTK) references TaiKhoan(MaTK)
);

create table DonHuy(
MaDonXin varchar(20) primary key,
MaDT varchar(20),
LyDo nvarchar(100),
foreign key (MaDT) references DeTai(MaDT)
);
create table DonGiaHan(
MaDonXin varchar(20) primary key,
MaDT varchar(20),
GHDen date,
LyDo varchar(100),
foreign key (MaDT) references DeTai(MaDT)
);


insert into TaiKhoan values 
('tk7','14110110',N'Lecturers',N'Trần Thị Lý','1996-10-11','CNTT','Ly@gmail.com',null,'123','BIDV'),
('tk1','14110205',N'Manager',N'Trương Thành Tín','1996-10-11','CNTT','tin@gmail.com',null,'123','BIDV'),
('tk2','14110184',N'Admin',N'Nguyễn Văn Thắng','1996-10-11','CNTT','thang@gmail.com',null,'123','BIDV'),
('tk3','14110208',N'Lecturers',N'Lâm Xuân Triết','1996-10-11','CNTT','lxtriet@gmail.com',null,'123','BIDV'),
('tk4','14110180',N'Student',N'Lê Thị Thảo','1996-10-11','CNTT','ltthao@gmail.com',null,'123','BIDV'),
('tk5','14110183',N'Student',N'Lâm Siêu Vồn','1996-10-11','CNTT','lsvon@gmail.com',null,'123','BIDV'),
('tk6','14110183',N'Student',N'Lâm Siêu Nhân','1996-10-11','CNTT','lsnhan@gmail.com',null,'123','BIDV');

insert into LoaiTB values
('ltt1','Thông báo bình thường'),  -- Thông báo bình thường, thông báo hiển thị
('ltt2','Thông báo đăng ký đề tài'),  -- Thông báo chức năng
('ltt3','Thông báo hủy đề tài'),    -- Thông báo chức năng
('ltt4','Thông báo gia hạn đề tài') ; -- Thông báo chức năng

insert into ThongBao values 
('tb1','tk4','tk1');         -- Sinh viên gửi Quản lý
insert into ThongBao values ('tb2','tk1','tk4');        -- Quản lý gửi Sinh viên
insert into ThongBao values('tb3','tk5','tk1');         -- Sinh viên gửi Quản lý
insert into ThongBao values('tb4','tk1','tk5');        -- Quản lý gửi Sinh viên
insert into ThongBao values('tb5','tk3','tk1');         -- Giảng Viên gửi Quản Lý
insert into ThongBao values('tb6','tk1','tk3');          -- Quản Lý gửi Giảng Viên
insert into ThongBao values('tb7','tk1','tk1') ;          -- Quản Lý gửi chính nó  @@! làm cho nó có 

insert into TB_TK values
('cttb1','tb1','ltt4',N'Thông báo có yêu cầu gia hạn đề tài','2016-10-16'),   -- TB Quản Lý nhận
('cttb2','tb1','ltt2',N'Thông báo đăng ký đề tài mới','2016-11-1'),      -- -- TB Quản Lý nhận
('cttb3','tb2','ltt1',N'Thông báo đề tài hủy thành công','2016-11-1'),   -- TB Sinh Viên TK4 nhận
('cttb4','tb2','ltt1',N'Thông báo đề tài đã được nghiệm thu','2016-11-1'),   -- TB Sinh Viên TK4 nhận
('cttb5','tb2','ltt1',N'Thông báo đề tài đăng ký thành công','2016-11-1') ;  -- TB Sinh Viên TK4 nhận
insert into TB_TK values
('cttb6','tb3','ltt3',N'Thông báo có yêu cầu hủy đề tài','2016-10-16'),   -- TB Quản Lý nhận
('cttb7','tb3','ltt2',N'Thông báo đăng ký đề tài mới','2016-11-1'),      -- -- TB Quản Lý nhận
('cttb8','tb4','ltt1',N'Thông báo đề tài gia hạn thành công','2016-10-5'),   -- TB Sinh Viên TK5 nhận
('cttb9','tb4','ltt1',N'Thông báo đề tài đang trong thời gian nghiệm thu','2016-11-1'),  -- TB Sinh Viên TK5 nhận
('cttb10','tb4','ltt1',N'Thông báo đề tài đăng ký thành công','2016-12-6') ;  -- TB Sinh Viên TK5 nhận

insert into TB_TK values   
('cttb11','tb5','ltt2',N'Thông báo đăng ký đề tài mới','2016-11-1');      -- -- TB Quản Lý nhận
  

insert into TrangThai values
('tt1',N'Chưa duyệt'),   -- SV đăng ký đề tài, sau khi sv đăng ký
('tt2',N'Quản lý duyệt'),       -- Giảng Viên đã duyệt 
('tt3',N'Đang tiến hành'),   -- Quản lý đã duyệt
('tt4',N'Chờ duyệt hủy'),         -- SV gửi hủy đề tài 
('tt5',N'Đã hủy'),              -- Đề tài đã được hủy
('tt6',N'Chờ duyệt gia hạn'),       -- SV giử gia hạn đề tài
('tt7',N'Đang gia hạn'),          -- Đề tài đang được gia hạn
('tt8',N'Đang nghiệm thu'),         -- Đề tài trong thời gian nghiệm thu, sau khi QL phân công phản biện cho đề tài
('tt9',N'Đã nghiệm thu'),        -- Đề tài đã được nghiệm thu, sau khi phản biện đánh giá
('tt10',N'Chờ phê duyệt'),        -- GV,QL đăng ký đề tài
('tt11',N'Đăng ký thành công') ;    -- Đề tài GV,QL đăng ký thành công

-- De Tai cua TK4 --- Sinh Vien
insert into DeTai values  -- De tai yeu cau gia han
('dt1','dt1','tt6','tk4','tk5','tk6','tk3',N'Web kinh doanh',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
insert into DeTai values      -- De tai dang ky moi
('dt2',null,'tt1','tk4','tk5','tk6','tk3',N'Web kinh doanh',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
insert into DeTai values        -- De tai huy thanh cong
('dt3','dt3','tt5','tk4','tk5','tk6','tk1',N'Web kinh doanh','NXây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT','Phát triển','Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
insert into DeTai values        -- De tai da nghiem thu
('dt4','dt4','tt9','tk4','tk5','tk6','tk1',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
-- delete from DeTai where MaDT='dt5';
insert into DeTai values         -- De tai dang tien hanh
('dt5','dt5','tt3','tk4','tk5','tk6','tk3',N'Web kinh doanh',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
-- De Tai cua TK5 --- Sinh Vien

insert into DeTai values  -- De tai yeu cau huy
('dt6','dt6','tt4','tk5','tk4','tk6','tk1',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
-- delete from DeTai where MaDT='dt7';
insert into DeTai values  -- De tai dang ky moi
('dt7',null,'tt1','tk5','tk4','tk6','tk1',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );

insert into DeTai values   -- De tai gia han thanh cong
('dt8','dt8','tt7','tk5','tk4','tk6','tk3',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );

-- delete from DeTai where MaDT='dt9';
insert into DeTai values    -- De tai dang nghiem thu
('dt9','dt9','tt8','tk5','tk4','tk6','tk3',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
insert into DeTai values     -- De tai dang tien hanh
('dt10','dt10','tt3','tk5','tk4','tk6','tk1',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );

-- De tai cua TK 3 -- Giang Vien
insert into DeTai values   -- De tai cho phe duyet
('dt11',null,'tt10',null,null,null,'tk3',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
-- delete from DeTai where MaDT='dt12';
insert into DeTai values     -- De tai dang ky thanh cong
('dt12','dt12','tt11',null,null,null,'tk3',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );

-- De tai cua TK1 -- Quan Ly
-- delete from DeTai where MaDT='dt13';
insert into DeTai values     -- De tai dang ky thanh cong
('dt13','dt13','tt11',null,null,null,'tk1',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
-- delete from DeTai where MaDT='dt14';
insert into DeTai values     -- De tai dang ky thanh cong
('dt14','dt14','tt11',null,null,null,'tk1',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );
-- delete from DeTai where MaDT='dt15';
insert into DeTai values     -- De tai dang nghiem thu
('dt15','dt15','tt8','tk4','tk5','tk6','tk1',N'Nghiên cứu hệ thống nhúng',N'Xây dựng 1 trang web giúp',
N'Tự nhiên',N'Cơ bản','2016-8-8','2016-10-8',
N'Khoa CNTT',N'Phát triển',N'Phát triển',
N'Các cửa hàng đang rất cần có 1 trang web như vậy',null,null,null,null,null,2000000 );


insert into HoiDong values('hd1','tk3','tk7',null,'2016-10-10');
insert into HoiDong values('hd2','tk1','tk7',null,'2016-10-10');
-- Đề tài đã nghiệm thu của TK4
-- delete from CTNghiemThu where MaDT='dt4';
insert into CTNghiemThu values ('dt4','hd1',10,10,10,25,10,10,10,85,N'Bài làm khá tốt','2016-10-25','tk3') ;
insert into CTNghiemThu values ('dt4','hd1',10,10,10,20,10,10,10,80,N'Bài làm khá tốt','2016-10-25','tk7') ;
-- Đề tài đang trong thời gian nghiệm thu của TK5
-- delete from CTNghiemThu where MaDT='dt9';
insert into CTNghiemThu values ('dt9','hd1',null,null,null,null,null,null,null,null,null,null,'tk3');
insert into CTNghiemThu values ('dt9','hd1',null,null,null,null,null,null,null,null,null,null,'tk7');

-- Đề tài đang trong thời gian nghiệm thu của TK4
-- delete from CTNghiemThu where MaDT='dt15';
insert into CTNghiemThu values ('dt15','hd2',null,null,null,null,null,null,null,null,null,null,'tk1');
insert into CTNghiemThu values ('dt15','hd2',null,null,null,null,null,null,null,null,null,null,'tk7');

-- Đơn hủy đề tài của TK4
insert into DonHuy values('dhuy1','dt6',N'Lý do gia đình');

-- Đơn gia hạn đề tài của TK5
insert into DonGiaHan values('dgh1','dt1','2016-12-8',N'Lý do gia đình');


select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,
				 DeTai.NgayKetThuc as NgayNT, TrangThai.tenTT as TenTT,MatKhau as MSSV, HoTen as TenCN
				from DeTai,TaiKhoan,TrangThai
				 where DeTai.MaCN=TaiKhoan.MaTK and DeTai.MaTT=TrangThai.MaTT
				 and MaDT='dt5';

SELECT distinct hoidong.MaHD as MHD, TKChuTich.HoTen as TenCT, TKPhanBien.HoTen as TenPB
					,HoiDong.NgayThanhLap as NTL 
	        		FROM HoiDong,taikhoan as TKChuTich,
	        		taikhoan as TKPhanBien 
	        	where  TKChuTich.MaTK=hoidong.ChuTich 
	        		and TKPhanBien.MaTK=hoidong.PhanBien ;
DELETE FROM TB_TK WHERE MaTB ='tb1';

SELECT MaCTTB, loaitb.TenLoaiTB,TenNguoiGui.HoTen as TenNG, tb_tk.NgayGui
        		FROM ThongBao,LoaiTb,tb_tk,taikhoan, taikhoan as TenNguoiGui
        		where loaitb.MaLTB=tb_tk.MaLTB and thongbao.matb=tb_tk.Matb and thongbao.nguoinhan=taikhoan.matk
        		and TenNguoiGui.MaTK=thongbao.NguoiGui
        		and TaiKhoan.Quyen='Manager';

SELECT * FROM TaiKhoan where MaTK='tk1';

SELECT * FROM DeTai,TaiKhoan as TK1
       where  TK1.MaTK=DeTai.GVHD and  MaCN is null;
       SELECT * FROM DeTai,TaiKhoan as TK1
    where TK1.MaTK=DeTai.GVHD
        and MaDT='dt11';

select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,
				 DeTai.NgayKetThuc as NgayNT, TrangThai.tenTT as TenTT
				from DeTai,TaiKhoan,TrangThai
				 where DeTai.MaCN=TaiKhoan.MaTK and DeTai.MaTT=TrangThai.MaTT
			and TaiKhoan.Email='lsvon@gmail.com';

select detai.MaDT,TenDT,tensv.HoTen as TenSV,tengv.HoTen as TenGV,ctnghiemthu.MaHD as MHD 
        		from detai,ctnghiemthu,taikhoan as tensv,taikhoan as tengv 
        		where detai.MaDT=ctnghiemthu.MaDT and detai.GVHD=tengv.MaTK and detai.MaCN=tensv.MaTK;
SELECT distinct Quyen FROM TaiKhoan;

SELECT MaCTTB, ThongBao.MaTB, TinTB,NgayGui,Tk2.HoTen as TenNguoiGui FROM TB_TK,ThongBao,TaiKhoan,
       TaiKhoan as TK2 where ThongBao.MaTB=TB_TK.MaTB and 
       ThongBao.NguoiNhan=TaiKhoan.MaTK and ThongBao.NguoiGui=TK2.MaTK and TaiKhoan.Email='ltthao@gmail.com';
	
select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,
				TaiKhoan.HoTen as TenGVHD
				from DeTai,TaiKhoan,TrangThai where DeTai.GVHD=TaiKhoan.MaTK
				and DeTai.MaTT=TrangThai.MaTT and TrangThai.MaTT='tt11';
SELECT * FROM ThongBao inner join TaiKhoan on ThongBao.NguoiGui=TaiKhoan.MaTK
       Where ThongBao.NguoiGui='tk4';
       
update DeTai set MaCN='tk1' ,SinhVien1='tk4' ,SinhVien2='tk5' where MaDT='dt12';

SELECT loaitb.TenLoaiTB,TenNguoiGui.HoTen as TenNG,thongbao.NguoiGui, tb_tk.NgayGui
FROM ThongBao,LoaiTb,tb_tk,taikhoan, taikhoan as TenNguoiGui
where loaitb.MaLTB=tb_tk.MaLTB and thongbao.matb=tb_tk.Matb and thongbao.nguoinhan=taikhoan.matk
        and TenNguoiGui.MaTK=thongbao.NguoiGui
       and TaiKhoan.Quyen='Manager' and loaitb.MaLTB='ltt2';
       
select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,DeTai.NgayThucHien as NgayDK,
				TaiKhoan.HoTen as TenGVHD 
				from DeTai,TaiKhoan,TrangThai where DeTai.GVHD=TaiKhoan.MaTK
				and DeTai.MaTT=TrangThai.MaTT and TrangThai.MaTT='tt11';
                
SELECT distinct * FROM CTNghiemThu,HoiDong,TaiKhoan as ct, TaiKhoan as pb,DeTai,TaiKhoan
where CTNghiemThu.MaHD=HoiDong.MaHD and DeTai.MaDT=CTNghiemThu.MaDT 
and HoiDong.ChuTich=ct.MaTK and HoiDong.PhanBien=pb.MaTK 
and ctnghiemthu.MaTK=TaiKhoan.MaTK and ctnghiemthu.MaDT='dt15' ;
            
select DeTai.MaDT as MaDT, DeTai.TenDT as TenDT,TK1.HoTen as MaCN,TK2.HoTen as GVHD
			from DeTai,CTNghiemThu,HoiDong,TaiKhoan,TaiKhoan as TK1, TaiKhoan as TK2
			where DeTai.MaDT=CTNghiemThu.MaDT and CTNghiemThu.MaHD=HoiDong.MaHD and 
			(HoiDong.PhanBien=TaiKhoan.MaTK or HoiDong.ChuTich=TaiKhoan.MaTK)
			and TaiKhoan.Email='ly@gmail.com' and DeTai.MaCN=TK1.MaTK and DeTai.GVHD=TK2.MaTK and MaTT='tt8';
            
SELECT distinct * FROM CTNghiemThu,HoiDong,TaiKhoan,DeTai
where CTNghiemThu.MaHD=HoiDong.MaHD and DeTai.MaDT=CTNghiemThu.MaDT 
 and TaiKhoan.MaTK=CTNghiemThu.MaTK and CTNghiemThu.MaTK='tk1' and CTNghiemThu.MaDT='dt15';
 
SELECT distinct * FROM CTNghiemThu,HoiDong,TaiKhoan as ct, TaiKhoan as pb,DeTai,taikhoan
	        		where CTNghiemThu.MaHD=HoiDong.MaHD and DeTai.MaDT=CTNghiemThu.MaDT and
	        		HoiDong.ChuTich=ct.MaTK and HoiDong.PhanBien=pb.MaTK
	        		and ctnghiemthu.MaTK=TaiKhoan.MaTK and ctnghiemthu.MaDT='dt9';
                    
select distinct *
from detai
where detai.matt='tt10' or detai.matt='tt1'

