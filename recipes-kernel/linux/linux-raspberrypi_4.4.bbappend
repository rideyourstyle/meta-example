do_deploy_append() {

    sed -i "1 s/$/ smsc95xx.macaddr=B8:27:EB:88:0A:11/" ${DEPLOYDIR}/bcm2835-bootfiles/cmdline.txt

}
