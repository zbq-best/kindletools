package kindletools

/**
 * Created by 白 on 2016/4/7.
 */
class Utils {
    static String generateDirectory(def isGenerateTXT) {

        def result = "Directory:\n"
        def root = new File(Common.path)
        def count = 0

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
        def root = new File(Common.path)
        def hash = new HashSet()
        def count = 0

        root.eachFile { file ->
            if (file.isFile() && file.name.contains(".")) {
                hash.add(file.name.substring(0, file.name.lastIndexOf(".")))
            }
        }

        root.eachDir { dir ->
            if (dir.name.endsWith(".sdr")) {
                def target = dir.name - ".sdr"
                if (!hash.contains(target) && dir.deleteDir()) {
                    result += "\n" + dir.name
                    count++
                }
            }
        }

        result += "\n\nCount: " + count
    }
}
