
do_install_append (){

    echo "@reboot /sbin/ip link set can0 up type can bitrate 500000" >> ${D}${sysconfdir}/crontab

}
