package com.github.torczuk.sandbox.kotlin.dsl

import java.nio.file.Paths

sealed class Element(open val path: String) {
    private val elements = arrayListOf<Element>()

    fun file(fileName: String): File {
        val file = File(path, fileName)
        elements.add(file)
        return file
    }

    fun dir(name: String, init: Dir.() -> Unit): Dir {
        val dir = Dir(path, name)
        dir.init()
        elements.add(dir)
        return dir
    }
}

class File(path: String, name: String) : Element(path) {
    init {
        Paths.get(path, name).toFile().createNewFile()
    }
}

class Dir(path: String, name: String) : Element(path) {
    init {
        Paths.get(path, name).toFile().mkdir()
    }

    override val path: String = Paths.get(path, name).toString()
}

fun path(path: String, init: Dir.() -> Unit): Dir {
    val dir = Dir(path, "")
    dir.init()
    return dir
}

fun main() {
    path("/tmp/test") {
        dir("home/") {
            file(".bash_profile")
            dir(".ssh") {
                file("id_rsa")
                file("id_rsa.pub")
                file("known_hosts")
            }
        }
        dir("opt/") {
        }
        dir("lib/") {
        }
        dir("tmp/") {
        }
    }
}

//➜  /tmp tree /tmp/test -a
///tmp/test
//├── home
//│   ├── .bash_profile
//│   └── .ssh
//│       ├── id_rsa
//│       ├── id_rsa.pub
//│       └── known_hosts
//├── lib
//├── opt
//└── tmp