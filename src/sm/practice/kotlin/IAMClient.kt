package sm.practice.kotlin

import java.util.*

class IAMClient {

    fun printClient() {

        println("ThreadsWeb: ${Base64.getEncoder().encodeToString("ThreadsWeb:A5DCC129C76FFBD3D73".toByteArray(Charsets.UTF_8))}")
        println("serai-3partyapp: ${Base64.getEncoder().encodeToString("serai-3partyapp:tohPtl4rLvLZzGNwKid3vnOSBeHieUCo".toByteArray(Charsets.UTF_8))}")

        println("Ali, platform-profile: ${Base64.getEncoder().encodeToString("platform-profile:syc6sN3cOYahZZZbOI78shA0G4vzgG7Q".toByteArray(Charsets.UTF_8))}")

        println("FT, serai-3partyapp: ${Base64.getEncoder().encodeToString("serai-3partyapp:IguahUKSj3H4v4xJX344kSr1snF0PJdx".toByteArray(Charsets.UTF_8))}")
        println("FT, serai-manage: ${Base64.getEncoder().encodeToString("serai-manage:TBQBKSzbbHJqnkdv0c69xtE22BZtxMLz".toByteArray(Charsets.UTF_8))}")

        println("Prod, serai-manage: ${Base64.getEncoder().encodeToString("serai-manage:JCE1RANW4ICaZbtDEi7UuE4UN1TtHV1a".toByteArray(Charsets.UTF_8))}")

        val appEncrypt1 = RsaUtil.encrypt("1qaz2wsxY", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAysXjy1mUeGYLN1wytvaaW3Nd170KeJvYiZlkACUmJFIGoEu8w8QZDsuVYg2EYlB4pXXbiidsuR3R06fFAVbMCrLy4K8rOMcERCm/Ztr9EnTG2SyoiyneBsu6fVoERYs0KMTjAgRLsdVrNS0wPrzSdl0yZlyavQUKWcjZ6pE4eCNraw+SS8wqxUupBDIhWt8C5sPhVq+IBPjivSx9LXsHPOTllyA++EcjT/8E6MCFWTOO+/ALHzWzPQyJcfaLWZsg7MlXQQHETZsYq+8iTLFM+l7NJe0IJMDXzm/kgxwXPQS0ZHqJbuxDeLyXaXAcVgL70odQtzqAe2O07/zq+yzvaQIDAQAB")
        println("1qaz2wsxY appEncrypt: $appEncrypt1")

        val appEncrypt2 = RsaUtil.encrypt("1Password", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAysXjy1mUeGYLN1wytvaaW3Nd170KeJvYiZlkACUmJFIGoEu8w8QZDsuVYg2EYlB4pXXbiidsuR3R06fFAVbMCrLy4K8rOMcERCm/Ztr9EnTG2SyoiyneBsu6fVoERYs0KMTjAgRLsdVrNS0wPrzSdl0yZlyavQUKWcjZ6pE4eCNraw+SS8wqxUupBDIhWt8C5sPhVq+IBPjivSx9LXsHPOTllyA++EcjT/8E6MCFWTOO+/ALHzWzPQyJcfaLWZsg7MlXQQHETZsYq+8iTLFM+l7NJe0IJMDXzm/kgxwXPQS0ZHqJbuxDeLyXaXAcVgL70odQtzqAe2O07/zq+yzvaQIDAQAB")
        println("1Password appEncrypt: $appEncrypt2")

    }

}