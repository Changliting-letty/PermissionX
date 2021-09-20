package com.permissionx.cltdev

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity

object PermissionX {

    private   const val  TAG="InvisibleFragment"
    fun request(activity: FragmentActivity,vararg perimissions:String,callBack: PermissionCallBack){

            val fragmentManager=activity.supportFragmentManager
            val existedFragment=fragmentManager.findFragmentByTag(TAG)
            val fragment=if (existedFragment!=null){
                existedFragment as InvisibleFragment
            }else
            {
                val invisibleFragment=InvisibleFragment()
                fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow()
                invisibleFragment
            }
        fragment.requestNow(callBack,*perimissions)
    }
}