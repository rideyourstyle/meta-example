

DESCRIPTION = "yocto python test"
SECTION = "examples"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d41d8cd98f00b204e9800998ecf8427e"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV = "master"
SRC_URI = "git://github.com/rideyourstyle/can-commander.git"
S = "${WORKDIR}/git"

ALLOW_EMPTY_${PN} = "1"
RDEPENDS_${PN} = "python-can"


do_compile () {
}

do_install() {
  install -m 0755 -d ${D}/root/examples/
  install -m 0755 -d ${D}/root/examples/can-commander/
  install -m 0777 ${S}/start.py ${D}/root/examples/
  cp -r ${S}/can-commander/* ${D}/root/examples/can-commander/
}


FILES_${PN} = " \
/root/examples/start.py \
/root/examples/can-commander/test.py \
"

pkg_postinst_${PN} () {
  #!/bin/sh -e
  
  cd /root/examples/can-commander
  python test.py
}
