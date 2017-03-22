

DESCRIPTION = "yocto python test"
SECTION = "examples"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d41d8cd98f00b204e9800998ecf8427e"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rideyourstyle/can-commander.git"
S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"
RDEPENDS_${PN} = "python-can \
                  python-pyserial \
                  python3-pyserial \
                  python-threading \
                  python3-threading"


do_compile () {
}

do_install() {
  install -m 0755 -d ${D}/home/root/can-commander/
  install -m 0755 -d ${D}/home/root/can-commander/files/
  install -m 0777 ${S}/start.py ${D}/home/root/can-commander/
  cp -r ${S}/can-commander/* ${D}/home/root/can-commander/files/
}


FILES_${PN} = " \
/home/root/can-commander/start.py \
/home/root/can-commander/files/test.py \
"

pkg_postinst_${PN} () {
  #!/bin/sh -e
  
  cd /home/root/can-commander/files
  python test.py
}
