package utils
/**
 * Created by 白 on 2016/4/7.
 */
class Utils {
    static def root = new File(".")

    static String generateDirectory(def isGenerateTXT) {

        def result = "Directory:\n"

        root.eachDir { dir ->
            if (dir.name.contains("documents")) {
                root = dir
                return result
            }
        }

        if (!root.name.contains("documents")) {
            result +=  "\nCount: 0"
            return result
        }

        def count = 0;
        root.eachFile { file ->

            if (file.isFile()) {
                result +=  "\n" + file.name
                count++
            }
        }

        result += "\n\nCount: " + count

        if (isGenerateTXT) {
            new File("kindle-directory.txt").write(result.replaceAll("\n", "\r\n"))
        }

        result
    }

    static String deleteSdr() {
        def result = "Delete sdr: \n"

        root.eachDir { dir ->
            if (dir.name.contains("documents")) {
                root = dir
                return result
            }
        }

        if (!root.name.contains("documents")) {
            return result
        }

        root.eachDir { dir ->
            if (dir.name.endsWith(".sdr")) {
                def target = dir.name - ".sdr"
                def flag = false
                root.eachFile { file ->
                    if (file.isFile() && file.name.contains(target)) {
                        flag = true
                        return result
                    }
                }
                if (!flag && dir.deleteDir()) {
                    result += "\n" + dir.name
                }
            }
        }

        result
    }
}
