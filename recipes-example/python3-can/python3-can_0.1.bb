SUMMARY = "Python module to add python-can to the image"
HOMEPAGE = "https://github.com/hardbyte/python-can"
SECTION = "devel/python"
LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=38138baa100d7259934590850bc0406e"


SRCNAME = "python3-can"
SRCREV = "737662b8c18f5b595f4f4b7539f20dcac32492a5"
SRC_URI = "git://github.com/hardbyte/python-can.git;branch=develop"

#SRC_URI[md5sum] = "5e3790426ffb53f3b5fd78f209c44516"
#SRC_URI[sha256sum] = "88ac5b8518d388dd42c29284c0516d9372a80eb5e936e71c6435c24699ebe615"

#S = "${WORKDIR}/${SRCNAME}-${PV}"
S = "${WORKDIR}/git"

inherit setuptools

DEPENDS = "python3"

RDEPENDS_${PN} += " \
    python3-logging \
    "
