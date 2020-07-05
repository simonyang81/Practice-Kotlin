package sm.practice.kotlin

import org.apache.commons.codec.binary.Base64
import java.security.GeneralSecurityException
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.SecureRandom
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import java.security.spec.PKCS8EncodedKeySpec
import java.security.interfaces.RSAPrivateKey

class RsaUtil {

    companion object {

        fun generateRsaKey(keySize: Int): Map<String, String> {

            val result = mutableMapOf<String, String>()
            try {
                val keyPairGen = KeyPairGenerator.getInstance("RSA")

                keyPairGen.initialize(keySize, SecureRandom())
                val keyPair = keyPairGen.generateKeyPair()
                result["publicKey"] = Base64.encodeBase64String(keyPair.public.encoded)
                result["privateKey"] = Base64.encodeBase64String(keyPair.private.encoded)

            } catch (e: GeneralSecurityException) {

            }
            return result

        }

        fun encrypt(str: String, publicKey: String): String {

            val decoded = Base64.decodeBase64(publicKey);
            val pubKey = KeyFactory.getInstance("RSA").generatePublic(X509EncodedKeySpec(decoded))

            val cipher = Cipher.getInstance("RSA")
            cipher.init(Cipher.ENCRYPT_MODE, pubKey)

            return Base64.encodeBase64String(cipher.doFinal(str.toByteArray(Charsets.UTF_8)))
        }

        fun decrypt(encrypt: String, privateKey: String): String {

            val inputByte = Base64.decodeBase64(encrypt.toByteArray(Charsets.UTF_8))
            val decoded = Base64.decodeBase64(privateKey)
            val priKey = KeyFactory.getInstance("RSA").generatePrivate(PKCS8EncodedKeySpec(decoded)) as RSAPrivateKey
            val cipher = Cipher.getInstance("RSA")
            cipher.init(Cipher.DECRYPT_MODE, priKey)

            return String(cipher.doFinal(inputByte))
        }

    }


}