
create database KhachSanBTL
ON PRIMARY 
(
NAME=QLKS_DATA,
FILENAME= 'E:\BainhomPTUD\Cosodulieu_chinhthuc\QLKS_DATA.mdf',
SIZE = 10, MAXSIZE = 50, FILEGROWTH = 15%)

LOG ON
(NAME=QLKS_LOG,
FILENAME= 'E:\BainhomPTUD\Cosodulieu_chinhthuc\QLKS_LOG.ldf',
SIZE= 15, MAXSIZE = 50, FILEGROWTH =20%)

use KhachSanBTL

create table LoaiPhong(
	maLoai varchar(20) primary key not null,
	tenLoai nvarchar(30),
	ghiChu nvarchar(50)
)
create table Phong(
	maPhong varchar(20) primary key not null,
	maLoai varchar(20) foreign key references LoaiPhong(maLoai) on delete cascade,
	tenPhong nvarchar(30),
	dienTich int,
	giaThue money

)
create table NhanVien(
	maNhanVien varchar(20) primary key not null ,
	chucVu nvarchar(30),
	hoTen nvarchar(30),
	diaChi nvarchar(50),
	ngaySinh datetime,
	soDienThoai nvarchar(11),
	
)
create table KhachHang(
	maKhachHang varchar(20) primary key not null,
	tenKhachHang nvarchar(30),
	diaChi nvarchar(50),
	soDienThoai nvarchar(11),
	CMND nvarchar(9),
	ghiChu nvarchar(50)
)
create table DichVu(
	maDichVu varchar(20) primary key not null,
	tenDichVu nvarchar(30),
	giaTien money
)
create table ThuePhong(
	maThue varchar(20) primary key not null,
	maKhachHang varchar(20) foreign key references KhachHang(maKhachHang) on delete cascade,
	maPhong varchar(20) foreign key references Phong(maPhong) on delete cascade, 
	maNhanVien varchar(20) foreign key references NhanVien(maNhanVien) on delete cascade,
	ngayVao datetime,
	ngayRa datetime,
	datCoc money--o tren kie
)
create table SuDungDichVu(
	maSuDung varchar(20) primary key not null,
	maThue varchar(20) foreign key references ThuePhong(maThue) on delete cascade,
	maDichVu varchar(20) foreign key references DichVu(maDichVu) on delete cascade,
	ngaySuDung datetime,
	soLuong int
)
create table ThanhToan(
	maThue varchar(20) foreign key references ThuePhong(maThue) on delete cascade,
	thanhTien money,
	hinhThucThanhToan nvarchar(50),
	ghiChu nvarchar(50),
	ngayThanhToan datetime
)
create table NhanSu(
	maNhanVien varchar(20) foreign key references NhanVien(maNhanVien) on delete cascade,
	tenDangNhap varchar(20),
	maKhau char(20)
)
--Du lieu Nhan Vien
Insert [dbo].[NhanVien] values ('NV1', N'Trưởng Phòng', N'Nguyễn Năm Nữ', N'Cà mau', '04/06/1998','094736786')
Insert [dbo].[NhanVien] values ('NV2', N'Nhân Viên', N'Nguyễn Khánh Vi', N'Bến tre', '02/09/1991','094765784')
Insert [dbo].[NhanVien] values ('NV3', N'Phó phòng', N'Nguyễn Văn Khánh', N'Tiền Giang', '03/02/1990','094745643')
Insert [dbo].[NhanVien] values ('NV4', N'Trưởng Phòng', N'Nguyễn Nam', N'Cà mau', '04/06/1998','094736786')
Insert [dbo].[NhanVien] values ('NV5', N'Nhân Viên', N'Nguyễn Khánh Viễn', N'Bến tre', '02/09/1991','094765784')
Insert [dbo].[NhanVien] values ('NV6', N'Phó phòng', N'Nguyễn Văn Khánh Phong', N'Tiền Giang', '03/02/1990','094745643')
Insert [dbo].[NhanVien] values ('NV7', N'Trưởng Phòng', N'Nguyễn Năm Căn', N'Cà mau', '04/06/1998','094736786')
Insert [dbo].[NhanVien] values ('NV8', N'Nhân Viên', N'Nguyễn Khánh Vĩnh', N'Bến tre', '02/09/1991','094765784')
Insert [dbo].[NhanVien] values ('NV9', N'Phó phòng', N'Nguyễn Văn Khanh', N'Tiền Giang', '03/02/1990','094745643')
Insert [dbo].[NhanVien] values ('NV10', N'Trưởng Phòng', N'Nguyễn Mai', N'Cà mau', '04/06/1998','094736786')
Insert [dbo].[NhanVien] values ('NV11', N'Nhân Viên', N'Nguyễn Khánh Tòng', N'Bến tre', '02/09/1991','094765784')
Insert [dbo].[NhanVien] values ('NV12', N'Phó phòng', N'Nguyễn Trần Phương', N'Tiền Giang', '03/02/1990','094745643')

-- Du lieu khach hang
insert [dbo].[KhachHang] values('KH2',N'Nguyen Tam','Kien Giang','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH3',N'Minh Tam','Hau Giang','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH4',N'An Nhien','Ha Nam','0909123102','371325524',null)
insert [dbo].[KhachHang] values('KH5',N'Nhất Thiên','Kien Giang','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH6',N'Quốc Hậu','Hau Giang','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH7',N'Tiến Cảnh','Ha Nam','0909123102','371325524',null)
insert [dbo].[KhachHang] values('KH8',N'Chí Công','Huế','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH9',N'Thủy Tiên','Tân Lập,Kiên Giang','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH10',N'Quỳnh Như','Phú Yên','0909123102','371325524',null)
insert [dbo].[KhachHang] values('KH11',N'Mỹ Phụng','Sóc Trăng','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH12',N'Ngọc Trân','Rạch Giá','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH13',N'Yến Nhi','Đồng Nai','0909123102','371325524',null)
insert [dbo].[KhachHang] values('KH14',N'Tố My','Cao Bằng','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH15',N'Minh Trí','Campuchia','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH16',N'Thị Láng','Hà Nam','0909123102','371325524',null)
insert [dbo].[KhachHang] values('KH17',N'Long Hải','Cà Mau','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH18',N'Đức Tiến','Giồng Riềng','0909131102','371325524',null)
insert [dbo].[KhachHang] values('KH19',N'Phước Tuấn','Hà Tĩnh','0909123102','371325524',null)

--Du lieu loai phong

Insert [dbo].[LoaiPhong]([maLoai], [tenLoai], [ghiChu])
values ('LP1', N'Đơn',N'Khong')
Insert [dbo].[LoaiPhong]([maLoai], [tenLoai], [ghiChu])
values ('LP2', N'Đôi',N'Khong')
Insert [dbo].[LoaiPhong]([maLoai], [tenLoai], [ghiChu])
values ('LP3', N'Tập thể',N'Khong')

--Du lieu phong
Insert [dbo].[Phong] values ('P101','LP1', 'P709', 4, 200000)
Insert [dbo].[Phong] values ('P102','LP2', 'P909', 5, 300000)
Insert [dbo].[Phong] values ('P103','LP3', 'P109', 6, 500000)
Insert [dbo].[Phong] values ('P104','LP1', 'P709', 4, 200000)
Insert [dbo].[Phong] values ('P105','LP2', 'P909', 5, 300000)
Insert [dbo].[Phong] values ('P106','LP3', 'P109', 6, 500000)
Insert [dbo].[Phong] values ('P107','LP1', 'P709', 4, 200000)
Insert [dbo].[Phong] values ('P201','LP2', 'P909', 5, 300000)
Insert [dbo].[Phong] values ('P202','LP3', 'P109', 6, 500000)
Insert [dbo].[Phong] values ('P203','LP1', 'P709', 4, 200000)
Insert [dbo].[Phong] values ('P204','LP2', 'P909', 5, 300000)
Insert [dbo].[Phong] values ('P205','LP3', 'P109', 6, 500000)
Insert [dbo].[Phong] values ('P206','LP1', 'P709', 4, 200000)
Insert [dbo].[Phong] values ('P207','LP2', 'P909', 5, 300000)
Insert [dbo].[Phong] values ('P208','LP3', 'P109', 6, 500000)
Insert [dbo].[Phong] values ('P301','LP1', 'P709', 4, 200000)
Insert [dbo].[Phong] values ('P302','LP2', 'P909', 5, 300000)
Insert [dbo].[Phong] values ('P303','LP3', 'P109', 6, 500000)
Insert [dbo].[Phong] values ('P304','LP1', 'P709', 4, 200000)
Insert [dbo].[Phong] values ('P305','LP2', 'P909', 5, 300000)
Insert [dbo].[Phong] values ('P306','LP3', 'P109', 6, 500000)

insert DichVu values ('DV1',N'Nước ngọt',15000)
insert DichVu values ('DV2',N'Xe đạp',30000)
insert DichVu values ('DV3',N'Xe máy',150000)
insert DichVu values ('DV4',N'Sting',15000)
insert DichVu values ('DV5',N'Mì Trứng',10000)
insert DichVu values ('DV6',N'Mì khô',12000)
insert DichVu values ('DV7',N'Dr.Thanh',15000)
insert DichVu values ('DV8',N'Mirinda',15000)
insert DichVu values ('DV9',N'Dừa tươi',250000)
insert DichVu values ('DV10',N'NumberOne',15000)
insert DichVu values ('DV11',N'Yaour',20000)
insert DichVu values ('DV12',N'Cam vắt',15000)
insert DichVu values ('DV13',N'Bí dao',15000)
insert DichVu values ('DV14',N'Hồng trà',25000)
insert DichVu values ('DV15',N'Cacao',250000)
insert DichVu values ('DV16',N'Nước suối',10000)
insert DichVu values ('DV27',N'7 up',15000)
insert DichVu values ('DV18',N'Trái cây',40000)
insert DichVu values ('DV19',N'Trà sữa',35000)
insert DichVu values ('DV20',N'Milo',15000)
insert DichVu values ('DV21',N'Sữa tươi',250000)
insert DichVu values ('DV22',N'Cocacola',15000)
insert DichVu values ('DV23',N'Sinh tố bơ',25000)
insert DichVu values ('DV24',N'Sinh tố măng cầu',25000)


insert ThuePhong values ('TP5','KH8','P102','NV1','9/21/2019','09/25/2019',1100000)
insert ThuePhong values ('TP9','KH9','P203','NV2','09/02/2019','09/21/2019',1900000)
insert ThuePhong values ('TP10','KH7','P206','NV3','9/21/2019','10/05/2019',900000)
insert ThuePhong values ('TP1','KH8','P102','NV1','9/21/2019','09/25/2019',1100000)
insert ThuePhong values ('TP2','KH9','P203','NV2','09/02/2019','09/21/2019',1900000)
insert ThuePhong values ('TP3','KH7','P206','NV3','9/21/2019','10/05/2019',900000)


insert SuDungDichVu values('SDDV1','TP1','DV1','09/21/2019',5)
insert SuDungDichVu values('SDDV2','TP1','DV3','09/15/2019',3)
insert SuDungDichVu values('SDDV3','TP3','DV2','09/29/2019',1)

insert ThanhToan values ('TP1',200000,N'Tiền mặt','Không','09/25/2019') 
insert ThanhToan values ('TP2',300000,N'Thẻ thanh toán','Đã thanh toán','09/21/2019')
insert ThanhToan values ('TP10',2500000,N'Chuyển khoản','Không','10/05/2019')
insert ThanhToan values ('TP9',150000,N'Thẻ thanh toán','Không','05/2/2016')
insert ThanhToan values ('TP3',150000,N'Tiền mặt','Không','01/28/2015')
insert ThanhToan values ('TP2',150000,N'Chuyển khoản','Không','03/12/2017')
insert ThanhToan values ('TP3',150000,N'Tiền mặt','Không','09/2/2018')
insert ThanhToan values ('TP3',150000,N'Tiền mặt','Không','09/2/2018')

insert NhanSu values('NV1','NguyenVanAn','123')
insert NhanSu values('NV1','NguyenTuan','tuan@111')
insert NhanSu values('NV1','HaTu','123123')


CREATE PROCEDURE TinhTong(@maThue nvarchar(20))
AS
	select sum(((day([ngayRa])-Day([ngayVao]))*[giaThue])) + sum(([soLuong]*[giaTien]))
	from  [dbo].[Phong] p join [dbo].[ThuePhong] tp on p.maPhong=tp.maPhong
		join SuDungDichVu sddv on sddv.maThue=tp.maThue
		join DichVu dv on dv.maDichVu=sddv.maDichVu
	where tp.[maThue]=@maThue
GO

