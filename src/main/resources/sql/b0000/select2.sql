select * from T_USERR where 1=1
<#if userid??>
        AND user_id = :userid
</#if>
<#if mailaddr??>
        AND mail_addr = :mailaddr
</#if>
<#if delflg??>
        AND del_flg = :delflg
</#if>